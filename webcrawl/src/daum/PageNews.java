/*
 * ���� ���� ����� ������������ �о
 * �� ��縶�� ����� ������ ����
 * (1page : ��� 15��, 10page = 150�� ���)
 */
package daum;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PageNews {
	public static void main(String[] args) throws IOException {
		String base = "https://news.daum.net/breakingnews?page=3";
		int page = 1;
		String url = base + page;
		int count = 0; // �����Ǽ�
		
		System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ� START �ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
		while(true) {
		for(int i = 1; 1<= 3; i++ ) { // 1, 2, 3page
			// �ش� �������� ��ü ����(�±�)
			Document doc = Jsoup.connect(url).get();
			// �ش� �������� ��� ����� ���� (1page�� 15��)
			Elements headLine = doc.select("ul.list_allnews strong.tit_thumb > a.link_txt");
			// System.out.println(urls);
			
			// ������ �������� ���� ����!
			if(headLine.isEmpty()) {
				break;
			}
			// 1 �������� ��� ��Ͽ��� 1�Ǿ� ���� => element�� ���
			for(Element element : headLine) {
				// ���� ��ü ī��Ʈ �� + 1 ����
				count++;
				
				// �ܰ� ��µ� ��翡�� href �Ӽ��� ����
				String href = element.attr("href");
				// �ܰ� ��µ� ��� ��ü ����(�±�)
				Document docNews = Jsoup.connect(href).get();
				// �ܰ� ��µ� ����� ����(title)
				Elements title = docNews.select("h3.tit_view");
				// �ܰ� ��µ� ����� ����(content)
				Elements content = docNews.select("div#harmonyContainer");
				
				// �ܰ� ��� ���(���� + ����)
				System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�"+count+"�� �ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
				System.out.println("����:" + title.text()); 
				System.out.println("����:" + content.text());
				
			}
			// ���� ������ �̵�
			page = page + 1;
			url = base + page;
		}
		// ���� �Ϸ�, ��ü ������ ���
		System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ� end �ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
		System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
		System.out.println("�ƢƢ� Daum ������ ���� �� " + count +"�� ����");
		System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
			
		}
	}

}
