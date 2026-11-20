package mylab.book.control;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

public class StatisticsAnalyzer {

	// 타입별 평균 가격 계산
	public Map<String, Double> calculateAveragePriceByType(Publication[] publications) {
		Map<String, Integer> totalPrices = new HashMap<String, Integer>();
		Map<String, Integer> counts = new HashMap<String, Integer>();
		for (Publication publication : publications) {
			String type = getPublicationType(publication);
			totalPrices.put(type, totalPrices.getOrDefault(type, 0) + publication.getPrice());
			counts.put(type, counts.getOrDefault(type, 0) + 1);
		}
		Map<String, Double> averages = new HashMap<String, Double>();
		for (String type : totalPrices.keySet()) {
			averages.put(type, (double) totalPrices.get(type) / counts.get(type));
		}
		return averages;
	}

	// 출판물 유형 분포 계산
	public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
		Map<String, Integer> counts = new HashMap<String, Integer>();
		for (Publication publication : publications) {
			String type = getPublicationType(publication);
			counts.put(type, counts.getOrDefault(type, 0) + 1);
		}
		Map<String, Double> distribution = new HashMap<String, Double>();
		for (String type : counts.keySet()) {
			distribution.put(type, counts.get(type) * 100.0 / publications.length);
		}
		return distribution;
	}

	// 특정 연도 출판물 비율 계산
	public double calculatePublicationRatioByYear(Publication[] publications, String year) {
		int count = 0;
		for (Publication publication : publications) {
			if (publication.getPublishDate().substring(0, 4).equals(year)) {
				count++;
			}
		}
		return count * 100.0 / publications.length;
	}

	// 출판물 타입 확인
	private String getPublicationType(Publication pub) {
		if (pub instanceof Novel) {
			return "소설";
		} else if (pub instanceof Magazine) {
			return "잡지";
		} else if (pub instanceof ReferenceBook) {
			return "참고서";
		} else {
			return "기타";
		}
	}

	// 통계 정보 출력 메서드
	public void printStatistics(Publication[] publications) {
		DecimalFormat format = new DecimalFormat("#,###.##");
		System.out.println("\n===== 출판물 통계 분석 =====");
		System.out.println("1. 타입별 평균 가격:");
		Map<String, Double> averages = calculateAveragePriceByType(publications);
		for (Map.Entry<String, Double> entry : averages.entrySet()) {
			System.out.println("   - " + entry.getKey() + ": " + format.format(entry.getValue()) + "원");
		}
		System.out.println("\n2. 출판물 유형 분포:");
		Map<String, Double> distribution = calculatePublicationDistribution(publications);
		for (Map.Entry<String, Double> entry : distribution.entrySet()) {
			System.out.println("   - " + entry.getKey() + ": " + format.format(entry.getValue()) + "%");
		}
		System.out.println("\n3. 2007년에 출판된 출판물 비율: "
				+ format.format(calculatePublicationRatioByYear(publications, "2007")) + "%");
	}
}
