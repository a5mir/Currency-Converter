package main;

import javafx.stage.Stage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class ScrapingClass {
    final String url = "https://www.ecb.europa.eu/stats/policy_and_exchange_rates/euro_reference_exchange_rates/html/index.en.html";
    Currency c = new Currency();
    ArrayList<Currency> list = new ArrayList<>();

    public void populateList() {
        try {
            final Document document = Jsoup.connect(url).get();
            for (Element row : document.select("table.ecb-forexTable.fullWidth tr")){
                if(!row.select("td.currency").text().equals("") ) {
                    final String image = row.select("td.currency").text();
                    final String name = row.select("td.alignLeft").text();
                    final double spot = Double.parseDouble(row.select("td.spot.number").text());
                    list.add(new Currency(name, spot, image));
                }
            }
            c.setList(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
