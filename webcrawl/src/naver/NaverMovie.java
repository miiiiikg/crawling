package naver;

import java.io.IOException;

import javax.swing.text.AbstractDocument.Content;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NaverMovie {
	public static void main(String[] args) throws IOException {
		
	String base = "https://movie.naver.com/movie/bi/mi/pointWriteFormList.nhn?code=191431&type=after&isActualPointWriteExecute=false&isMileageSubscriptionAlready=false&isMileageSubscriptionReject=false&page=";
	
	int page = 1;
	String url = base + page;
	
	int score = 0, regdate = 0, count = 0;
	String title = "", writer, content, basedate, subdate = "";
	
	int total = 0;
	double scoreAvg = 0.0;
	
	while(true) {
		Document doc = Jsoup.connect(url).get();
		Elements reply = doc.select("div.score_result li");
	
		
		if(reply.isEmpty()) {
			break;
		}
		// for(int i = 0; i<reply.size(); i++
		// content = reply.get(i).select
		for(Element one : reply) {
			count++;
//			Elements movieName = doc.select("");
//			title = movieName.text();
			writer = one.select("div.score_reple dl span").text(); // �ۼ���
			score = Integer.parseInt(one.select("div.star_score > em").text()); // ����
			content = one.select("div.score_reple > p").text(); // ����
			basedate = one.select("div.score_reple dt em:last-child").text();
			subdate = basedate.substring(0,10); 
			regdate = Integer.parseInt(subdate.replace(".","")); // ��¥�Է�
			
			total += score;
		
			System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢ�"+count+"�� �ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
			System.out.println("��ȭ: "+title);
			System.out.println("����: "+score);
			System.out.println("�ۼ��� : "+ writer);
			System.out.println("����: " + content);
			System.out.println("�ۼ�����: " +regdate);
			
		}// for��
		
		page = page + 1;
		url = base + page;
	
	}// while ��
	
	System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ� end �ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
	System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
	System.out.println("�ƢƢƢ� "+ title +"Naver ��ȭ ���� ���� ��� ");
	System.out.println("�ƢƢƢ� "+ (page-1) + "����������");
	System.out.println("�ƢƢƢ� "+ count +"���� ������ ���� �Ϸ�");
//	System.out.println("�ƢƢƢ� ��������� " + result +"�� :)");
	System.out.println("�ƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢƢ�");
	
	}// ����
	
	
	
}
