// JavaでAPIエンドポイントを作成
package com.example.bmr;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // BmrControllerクラスはRESTAPIコントローラー RESTAPIを提供するクラス
@RequestMapping("/api") // URLパス クライアントのリクエストを処理
@CrossOrigin(origins = "http://localhost:5173") // フロントエンドのURLを指定
public class BmrController {

    // リクエストを受け取るBmrRequestクラスと、結果を返すBmrResultクラスを作る

    @PostMapping("/calculate") // PostMappingメソッドはPOSTリクエストを受け取ったときに動作
    public BmrResult calculateBmr(@RequestBody BmrRequest request) {
        double bmr;

        if (request.getGender().equals("man")) { // 男だったらでのif文
            // 男性版計算式
            bmr = (13.397 * request.getWeight()) + (4.799 * request.getHeight()) - (5.677 * request.getAge() + 88.362);
        } else {
            // 女性版計算式
            bmr = (9.247 * request.getWeight()) + (3.098 * request.getHeight() - 4.33) * (request.getAge() + 447.593);
        }
        return new BmrResult(bmr);
    }
}
