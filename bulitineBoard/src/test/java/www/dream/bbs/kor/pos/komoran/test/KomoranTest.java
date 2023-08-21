package www.dream.bbs.kor.pos.komoran.test;

import java.util.List;

import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;
import www.dream.bbs.framework.nlp.pos.service.NounExtractor;

public class KomoranTest {

	public static void main(String[] args) {
		Komoran komoran = new Komoran(DEFAULT_MODEL.FULL);
		String document = "데이터분석은 참 재미있는 것 같아요";

//		KomoranResult nounList = NounExtractor.analyze(document);
//		List<String> nounList = nounList.getNouns();
//		for (String noun : nounList) {
//			System.out.println(noun);
//		}
//		
		
		
		
//		System.out.println(analyzeResultList.getPlainText());
//
//		List<Token> tokenList = analyzeResultList.getTokenList();
//		for (Token token : tokenList) {
//			System.out.format("(%2d, %2d) %s/%s\n", 
//					token.getBeginIndex(), 
//					token.getEndIndex(), 
//					token.getMorph(),
//					token.getPos());
//		}

	}
}
