package com.sg.flooring.constants;

public enum FlooringModeEnum {

	TRAINING, PRODUCTION, NONENV;

	private static int modeSelection;

	public static int getModeSelection() {
		return modeSelection;
	}

	public static void setModeSelection(int modeSelection) {
		FlooringModeEnum.modeSelection = modeSelection;
	}

	public static FlooringModeEnum getMode() {

		switch (getModeSelection()) {
		case 1:
			return TRAINING;
		case 2:
			return PRODUCTION;
		default:
			return NONENV;
		}

	}

}
