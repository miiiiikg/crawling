/*
 * ���� ���� 1�ǿ��� ����� ������ ����
 */
package daum;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;



public class OneNews {

	public static void main(String[] args) throws IOException{

		// �����͸� ���� �� ����Ʈ �ּ�
		String url = "https://entertain.v.daum.net/v/20200205143853187";
		
		// URL ������ ��ü �±׸� Select��
		Document doc = Jsoup.connect(url).get();
		
		// ��ü �±׿��� ���ϴ� �׸� select��
		Elements title = doc.select("h3.tit_view"); // ���� ����
		Elements content = doc.select("div#harmonyContainer"); // ���� ����
		
		// .text() >>> �±� �� �Ӽ��� ����� content ���븸 ����
		System.out.println(title.text()); // ���� ���
		System.out.println(content.text());

	}

}
