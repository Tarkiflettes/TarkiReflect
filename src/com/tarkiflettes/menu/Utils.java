package com.tarkiflettes.menu;

import java.awt.Color;

public class Utils {
	
	

	private static Color colorButton = new Color(41, 128, 185);
	private static Color colorButtonText = new Color(240, 240, 240);
	private static Color colorButtonMouseOver = new Color(52, 152, 219);
	
	//private static String[] buttonsNames = {"Jouir", "Multicouilles", "Opcons", "Quitteub"};
	private static String[] buttonsNames = {"Jouer", "Multijoueur", "Options", "Quitter"};
	private static Color[] buttonsColors = {colorButton, colorButton, colorButton,  colorButton};
	private static Color[] buttonsColorsText = {colorButtonText, colorButtonText, colorButtonText,  colorButtonText};
	public static int[] buttonsX = {-1, -1, -1, -1};
	private static int[] buttonsY = {150, 350, 550, 750};
	private static int[] buttonsWidth = {500, 500, 500, 500};
	private static int[] buttonsHeight = {150, 150, 150, 150};
	
	public static int whichButton(int x, int y) {
		for(int a = 0;a<buttonsNames.length;a++) {
			if (x>buttonsX[a] && y>buttonsY[a] && x<buttonsX[a]+buttonsWidth[a] && y<buttonsY[a]+buttonsHeight[a]) {
				return a;
			}
		}
		return -1;
	}
	
	
	public static Color getColorButton() {
		return colorButton;
	}
	public static void setColorButton(Color colorButton) {
		Utils.colorButton = colorButton;
	}

	public static Color getColorButtonMouseOver() {
		return colorButtonMouseOver;
	}
	public static void setColorButtonMouseOver(Color colorButtonMouseOver) {
		Utils.colorButtonMouseOver = colorButtonMouseOver;
	}

	public static Color getColorButtonText() {
		return colorButtonText;
	}
	public static void setColorButtonText(Color colorButtonText) {
		Utils.colorButtonText = colorButtonText;
	}

	public static String[] getButtonsNames() {
		return buttonsNames;
	}
	public static String getButtonName(int index) {
		if (Utils.buttonsNames.length>index)
			return buttonsNames[index];
		else
			return "";
	}
	public static void setButtonsNames(String[] buttonsNames) {
		Utils.buttonsNames = buttonsNames;
	}
	public static void setButtonName(String buttonName, int index) {
		if (Utils.buttonsNames.length>index)
			Utils.buttonsNames[index] = buttonName;
	}

	public static Color[] getButtonsColors() {
		return buttonsColors;
	}
	public static Color getButtonColor(int index) {
		if (Utils.buttonsColors.length>index)
			return buttonsColors[index];
		else
			return new Color(0, 0, 0);
	}
	public static void setButtonsColors(Color[] buttonsColors) {
		Utils.buttonsColors = buttonsColors;
	}
	public static void setButtonColor(Color color, int index) {
		if (Utils.buttonsColors.length>index)
			buttonsColors[index] = color;
	}

	public static int[] getButtonsX() {
		return buttonsX;
	}
	public static int getButtonX(int index) {
		if (Utils.buttonsX.length>index)
			return Utils.buttonsX[index];
		else 
			return 0;
	}
	public static void setButtonsX(int[] buttonsX) {
		Utils.buttonsX = buttonsX;
	}
	public static void setButtonX(int buttonsX, int index) {
		if (Utils.buttonsX.length>index)
			Utils.buttonsX[index] = buttonsX;
	}

	public static int[] getButtonsY() {
		return buttonsY;
	}
	public static int getButtonY(int index) {
		if (Utils.buttonsY.length>index)
			return Utils.buttonsY[index];
		else 
			return 0;
	}
	public static void setButtonsY(int[] buttonsY) {
		Utils.buttonsY = buttonsY;
	}
	public static void setButtonY(int buttonsY, int index) {
		if (Utils.buttonsY.length>index)
			Utils.buttonsY[index] = buttonsY;
	}
	
	public static int[] getButtonsWidth() {
		return buttonsWidth;
	}
	public static int getButtonWidth(int index) {
		if (Utils.buttonsWidth.length>index)
			return Utils.buttonsWidth[index];
		else 
			return 0;
	}
	public static void setButtonsWidth(int[] buttonsWidth) {
		Utils.buttonsWidth = buttonsWidth;
	}
	public static void setButtonWidth(int buttonsWidth, int index) {
		if (Utils.buttonsWidth.length>index)
			Utils.buttonsWidth[index] = buttonsWidth;
	}
	
	public static int[] getButtonsHeight() {
		return buttonsHeight;
	}	
	public static int getButtonHeight(int index) {
		if (Utils.buttonsHeight.length>index)
			return Utils.buttonsHeight[index];
		else 
			return 0;
	}
	public static void setButtonsHeight(int[] buttonsHeight) {
		Utils.buttonsHeight = buttonsHeight;
	}
	public static void setButtonHeight(int buttonsHeight, int index) {
		if (Utils.buttonsHeight.length>index)
			Utils.buttonsHeight[index] = buttonsHeight;
	}

	public static Color[] getButtonsColorsText() {
		return buttonsColorsText;
	}	
	public static Color getButtonColorText(int index) {
		if (Utils.buttonsColorsText.length>index)
			return Utils.buttonsColorsText[index];
		else 
			return new Color(0, 0, 0);
	}
	public static void setButtonsColorsText(Color[] buttonsColorsText) {
		Utils.buttonsColorsText = buttonsColorsText;
	}
	public static void setButtonColorText(Color buttonsColorsText, int index) {
		if (Utils.buttonsColorsText.length>index)
			Utils.buttonsColorsText[index] = buttonsColorsText;
	}
	
	public static int getElemCount() {
		return buttonsNames.length;
	}
	
}
