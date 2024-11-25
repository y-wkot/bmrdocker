// JavaでAPIエンドポイントを作成
package com.example.bmr;

import java.util.concurrent.atomic.AtomicInteger;

// import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // BmrControllerクラスはRESTAPIコントローラー RESTAPIを提供するクラス
@RequestMapping("/api") // URLパス クライアントのリクエストを処理
@CrossOrigin(origins = { "http://localhost:5173", "https://bmrfront.onrender.com" }) // フロントエンドのURLを指定、ローカルとRender両方を書いて動作確認にも対応
public class BmrController {

    // アクセスカウンター
    private AtomicInteger accessCount = new AtomicInteger(0);

    @GetMapping("/access-count")
    public int getAccessCount() {
        return accessCount.incrementAndGet(); // アクセスがあるたびにカウントを増加
    }

    // リクエストを受け取るBmrRequestクラスと、結果を返すBmrResultクラスを作る
    @PostMapping("/calculate") // PostMappingメソッドはPOSTリクエストを受け取ったときに動作
    public BmrResult calculateBmr(@RequestBody BmrRequest request) {
        double bmr = calculateBmrValue(request); // 計算ロジックを
        bmr *= request.getExerciseIntensity(); // 運動強度かけるよ
        return new BmrResult(bmr);
    }

    private double calculateBmrValue(BmrRequest request) { // 計算ロジックのメソッドだよ
        if (request.getGender().equals("man")) { // 男だったらでのif文
            // 男性版計算式
            return (13.397 * request.getWeight()) + (4.799 * request.getHeight()) - (5.677 * request.getAge()) + 88.362;
        } else {
            // 女性版計算式
            return (9.247 * request.getWeight()) + (3.098 * request.getHeight()) - (4.33 * request.getAge()) + 447.593;
        }
    }
}
