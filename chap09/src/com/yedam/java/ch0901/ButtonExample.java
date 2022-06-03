package com.yedam.java.ch0901;

import java.util.HashMap;
import java.util.Map;

public class ButtonExample {
	public static void main(String[] args) {
		Button button = new Button();
		Map i = new HashMap();
		button.setOnClickListener(new CallListener());
		button.touch();
		button.setOnClickListener(new MessageListener());
		button.touch();
	}
}
