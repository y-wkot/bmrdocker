package com.example.bmr;

public class BmrResult { // BmrResultクラスは基礎代謝の結果を保持するためのデータ
    private double bmr; // このクラスのインスタンス変数（フィールド）としてbmrを定義

    public BmrResult(double bmr) { // BmrResultクラスのコンストラクタ（インスタンス生成時に呼ばれるメソッド）コンストラクタ名はクラス名と一致
        this.bmr = bmr; // 引数として受け取ったbmr値をフィールドbmrに代入
    }

    public double getBmr() {
        return bmr;
    }

    public void setBmr(double bmr) {
        this.bmr = bmr;
    }
}
