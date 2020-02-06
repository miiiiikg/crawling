/*
 * ���� ���� ����� �� ��縶�� ����� ������ ����
 * (1Page���� ��ϸ� ex: ��� 10�� >> 10���� ���)
 */
package daum;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ListNews {
	public static void main(String[] args) throws IOException {
		String url = "https://news.daum.net/breakingnews/digital";
		Document doc = Jsoup.connect(url).get();
		
		Elements urls = doc.select("ul.list_allnews strong.tit_thumb > a.link_txt");
		// System.out.println(urls);
		
		int count = 0;
		for(Element element : urls) {
			count++;
			// attr()�� ����Ͽ� ���ϴ� �Ӽ��� ����
			String href = element.attr("href");
			
			Document docNews = Jsoup.connect(href).get();
			
			Elements title = docNews.select("h3.tit_view"); 
			Elements content = docNews.select("div#harmonyContainer");
			System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�"+count+"�� �ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
			System.out.println("����:" + title.text()); 
			System.out.println("����:" + content.text());
			
		}
		System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
		System.out.println("�ƢƢ� Daum ������ ���� �� " + count +"�� ����");
		System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
	}

}
