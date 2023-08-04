package www.dream.framework.display;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
public @interface FieldDispaly {

	// @FieldDispaly(order={3, 4, 4, 2}, caption="내용") 애노테이션활용법
	// 각 LRCU 화면에서의 출력 순서 -1 :no, 1~
	// Map<ViewType, Integer>
	int[] order();

	// 캡션
	String caption();

}
