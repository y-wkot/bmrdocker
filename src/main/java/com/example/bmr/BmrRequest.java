package com.example.bmr;

public class BmrRequest {
    private String gender; // man or other
    private int age; // 年齢
    private double height; // 身長cm
    private double weight; // 体重kg

    public String getGender() { // ゲッターメソッドgenderフィールドの値を取得し、String型で戻す。genderが文字列で保存。publicアクセス修飾子により他クラスからもアクセス可
        return gender; // 値を返す
    }

    public void setGender(String gender) { // セッターメソッドset動詞によりgender値の設定メソッドであることを明示的にする
        this.gender = gender; // string型を受け取りgenderフィールドへ代入。戻り値は不要なのでvoid,public同上。thisでフィールドgenderと引数genderを区別
    }

    // それぞれの項目のgetとsetを記述
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
