package www.dream.framework.display;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class VODisplayer {
	public static List<String> getCaptionList(Class cls, ViewType viewType) {
		List<String> ret = new ArrayList<>();

		Field[] fields = cls.getDeclaredFields();
		FieldDispaly[] displayes = new FieldDispaly[fields.length];

		for (Field field : cls.getDeclaredFields()) {
			FieldDispaly dis = field.getAnnotation(FieldDispaly.class);
			if (dis != null) {
				int 출력순서 = dis.order()[viewType.ordinal()];
				if (출력순서 != -1) {
					displayes[출력순서] = dis;
				}

			}

		}
		for (FieldDispaly fdAnno : displayes) {
			if (fdAnno != null)
				ret.add(fdAnno.caption());
		}

		return ret;
	}

	public static List<Object> getDataList(Object data, ViewType viewType) {
		List<Object> listFieldData = new ArrayList<>();

		Field[] fields = data.getClass().getDeclaredFields();
		Field[] displayOrder = new Field[fields.length];

		for (Field field : data.getClass().getDeclaredFields()) {
			FieldDispaly dis = field.getAnnotation(FieldDispaly.class);
			if (dis != null) {
				int 출력순서 = dis.order()[viewType.ordinal()];
				if (출력순서 != -1) {
					displayOrder[출력순서] = field;
				}

			}

		}

		for (Field 관심정보 : displayOrder) {
			if (관심정보 != null) {
				관심정보.setAccessible(true);
				try {
					listFieldData.add(관심정보.get(data));
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return listFieldData;
	}

}
