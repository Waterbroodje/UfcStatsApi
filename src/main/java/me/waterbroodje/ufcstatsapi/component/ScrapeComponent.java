package me.waterbroodje.ufcstatsapi.component;

import me.waterbroodje.JavaScraper;
import me.waterbroodje.ufcstatsapi.model.Fight;
import me.waterbroodje.ufcstatsapi.model.Fighter;
import me.waterbroodje.ufcstatsapi.model.Referee;
import me.waterbroodje.ufcstatsapi.service.FightService;
import me.waterbroodje.ufcstatsapi.service.FighterService;
import me.waterbroodje.ufcstatsapi.service.RefereeService;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicReference;

@Component
public class ScrapeComponent {

    @Autowired public static FightService fightService;
    @Autowired public static FighterService fighterService;
    @Autowired public static RefereeService refereeService;

    public static void main(String[] args) {
        JavaScraper javaScraper = new JavaScraper();
        Document document = javaScraper.getStaticDocument(
                "http://www.ufcstats.com/statistics/events/completed?page=all",
                true,
                true,
                JavaScraper.defaultHeaders());

        document.getElementsByClass("b-statistics__table-events")
                .get(0)
                .getElementsByTag("tbody")
                .get(0)
                .getElementsByTag("tr")
                .stream()
                .skip(2) // Skip the first event, it's the upcoming one which doesnt have fight data.
                .forEach(event -> {
                    String url = event.getElementsByTag("a").attr("href");
                    if (!url.isEmpty()) {
                        Document doc = javaScraper.getStaticDocument(
                                url,
                                true,
                                true,
                                JavaScraper.defaultHeaders()
                        );

                        doc.getElementsByClass("b-fight-details__table")
                                .get(0)
                                .getElementsByTag("tbody")
                                .get(0)
                                .getElementsByTag("tr")
                                .forEach(fight -> {
                                    String dataLink = fight.attr("data-link");
                                    if (!dataLink.isEmpty()) {
                                        Document fightPage = javaScraper.getStaticDocument(dataLink, true, true, JavaScraper.defaultHeaders());
                                        AtomicReference<Fighter> firstFighter = new AtomicReference<>();
                                        AtomicReference<Fighter> secondFighter = new AtomicReference<>();
                                        AtomicReference<String> firstFighterResult = new AtomicReference<>();
                                        AtomicReference<String> secondFighterResult = new AtomicReference<>();

                                        fightPage.getElementsByClass("b-fight-details")
                                                .get(0)
                                                .getElementsByClass("b-fight-details__person")
                                                .forEach(fightPerson -> {
                                                    String result = fightPerson.getElementsByTag("i").get(0).text().replaceAll(" ", "");
                                                    String fighterId = fightPerson.getElementsByClass("b-fight-details__person-link").get(0).attr("href").replace("http://www.ufcstats.com/fighter-details/", "");
                                                    String fighterName = fightPerson.getElementsByClass("b-fight-details__person-link").get(0).text();

                                                    if (firstFighter.get() == null) {
                                                        firstFighter.set(fighterService.getFighterById(fighterId).orElse(new Fighter()));
                                                        firstFighter.get().setId(fighterId);
                                                        firstFighter.get().setName(fighterName);

                                                        firstFighterResult.set(result);
                                                    } else {
                                                        secondFighter.set(fighterService.getFighterById(fighterId).orElse(new Fighter()));
                                                        secondFighter.get().setId(fighterId);
                                                        secondFighter.get().setName(fighterName);

                                                        secondFighterResult.set(result);
                                                    }
                                                });

                                        fighterService.saveFighter(firstFighter.get());
                                        fighterService.saveFighter(secondFighter.get());

                                        Element fightDetails = fightPage.getElementsByClass("b-fight-details__fight").first();
                                        String head = fightDetails.getElementsByClass("b-fight-details__fight-title").text();

                                        Element content = fightDetails.getElementsByClass("b-fight-details__content").first();

                                        // Get details
                                        String method = content.select(".b-fight-details__label:contains(Method:) + i").text();
                                        String round = content.select(".b-fight-details__label:contains(Round:)").first().nextSibling().toString().trim();
                                        String time = content.select(".b-fight-details__label:contains(Time:)").first().nextSibling().toString().trim();
                                        String timeFormat = content.select(".b-fight-details__label:contains(Time format:)").first().nextSibling().toString().trim();
                                        String referee = content.select(".b-fight-details__label:contains(Referee:) + span").text();
                                        String details = content.select(".b-fight-details__label:contains(Details:)").first().parent().parent().text().replace("Details: ", "");

                                        Fight databaseFight = fightService.getFight(dataLink.replace("http://www.ufcstats.com/fight-details/", "")).orElse(new Fight());
                                        databaseFight.setMethod(method);
                                        databaseFight.setRound(round);
                                        databaseFight.setTime(time);
                                        databaseFight.setTimeFormat(timeFormat);
                                        databaseFight.setDetails(details);
                                        databaseFight.setFirstFighterResult(firstFighterResult.get());
                                        databaseFight.setSecondFighterResult(secondFighterResult.get());

                                        Referee databaseReferee = refereeService.getRefereeByName(referee).orElse(new Referee());
                                        databaseReferee.setName(referee);
                                        refereeService.save(databaseReferee);

                                        databaseFight.setReferee(databaseReferee);

                                        fightService.save(databaseFight);
                                    }
                                });
                    }
                });
    }
}
