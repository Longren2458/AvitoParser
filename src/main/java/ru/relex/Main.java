package ru.relex;

import org.jsoup.Jsoup;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*=====Блок кода для ввода данных с консоли======*/
        Scanner userData = new Scanner(System.in);
        System.out.println("Введите поисковую фразу: ");
        String search_query = userData.nextLine().trim().replaceAll("\\s+", "+");
        System.out.println("Введите ID пользователя: ");
        String id_user = userData.nextLine();
        System.out.println("Введите город поиска: ");
        String city = userData.nextLine();
        /*=====Блок кода для ввода данных с консоли======*/

        /*=======Блок кода парсера======*/
        String url_parser = "https://www.avito.ru/" + city + "?q=" + search_query;
        System.out.println(url_parser);
        try {
            var document = Jsoup.connect(url_parser).get();
            var titleElement = document.select("div.items-items-kAJAg > div.iva-item-root-_lk9K");
            List<String> divList = new ArrayList<>();
            for (var element: titleElement){
//                System.out.println("Название объявления: " + element.text());
                divList.add(element.attr("id"));
            }
            int index_id = divList.indexOf(id_user);
            System.out.println(divList);
            System.out.println(index_id+1);
        } catch (Exception e){
            e.printStackTrace();
        }
        /*=======Блок кода парсера======*/
    }
}