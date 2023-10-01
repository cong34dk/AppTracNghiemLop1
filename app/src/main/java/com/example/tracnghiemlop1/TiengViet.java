package com.example.tracnghiemlop1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//implements View.OnClickListener Xử lý sự kiện khi người dùng tương tác
public class TiengViet extends AppCompatActivity implements View.OnClickListener {

    //Khai báo các biến giao diện
    TextView total_question, question;
    Button ansA, ansB, ansC, ansD;
    Button btnCauTruoc, btnCauSau, btnNopBai;

    //Khai báo các biến tính điểm
    int score = 0;
    int TongCauHoi = QuestionAnswerTiengViet.question.length;
    int viTriCauHoiHienTai = 0;
    String selectedAnswer = "";

    // Khai báo biến để theo dõi câu hỏi đã được trả lời
    boolean[] answeredQuestions = new boolean[TongCauHoi];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toan);

        //Ánh xạ
        total_question = findViewById(R.id.total_question);
        question = findViewById(R.id.question);
        ansA = findViewById(R.id.ans_A);
        ansB = findViewById(R.id.ans_B);
        ansC = findViewById(R.id.ans_C);
        ansD = findViewById(R.id.ans_D);
        btnCauTruoc = findViewById(R.id.btnCauTruoc);
        btnNopBai = findViewById(R.id.btnNopBai);
        btnCauSau = findViewById(R.id.btnCauSau);

        //Thiết lập lắng nghe click vào tất cả các nút

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        btnCauTruoc.setOnClickListener(this);
        btnCauSau.setOnClickListener(this);
        btnNopBai.setOnClickListener(this);


        //Hiển thị tổng số câu hỏi
        total_question.setText("Tổng số câu hỏi: " + TongCauHoi);

        loadNewQuestion();
    }


    // Xử lý sự kiện khi nút "Câu sau" được click
    private void handleNextButtonClick() {
        // Kiểm tra xem người dùng đã trả lời câu hỏi này chưa
        if (!answeredQuestions[viTriCauHoiHienTai]) {
            // Nếu mà Đáp án chọn là đáp án đúng thì điểm sẽ tăng lên
            if (selectedAnswer.equals(QuestionAnswerTiengViet.correctAnswers[viTriCauHoiHienTai])) {
                score++;
            }
            // Đánh dấu câu hỏi đã được trả lời
            answeredQuestions[viTriCauHoiHienTai] = true;
        }

        // Hiển thị câu hỏi tiếp theo
        viTriCauHoiHienTai++;
        loadNewQuestion();
    }

    // Xử lý sự kiện khi nút "Câu trước" được click
    private void handlePreviousButtonClick() {
        // Hiển thị câu hỏi trước
        viTriCauHoiHienTai--;
        loadNewQuestion();
    }

    // Xử lý sự kiện khi nút "Nộp bài" được click
    private void handleSubmitButtonClick() {
        // Kiểm tra xem người dùng đã trả lời câu hỏi này chưa
        if (!answeredQuestions[viTriCauHoiHienTai]) {
            // Nếu mà Đáp án chọn là đáp án đúng thì điểm sẽ tăng lên
            if (selectedAnswer.equals(QuestionAnswerTiengViet.correctAnswers[viTriCauHoiHienTai])) {
                score++;
            }
            // Đánh dấu câu hỏi đã được trả lời
            answeredQuestions[viTriCauHoiHienTai] = true;
        }

        //Tạo Intent để mở layout "Kết quả"
        Intent intent = new Intent(TiengViet.this, KetQua.class);
        //Khai báo Bundle
        Bundle bundle = new Bundle();
        //Đưa dữ liệu chuỗi vào bundle
        bundle.putString("tenMon", "Tiếng Việt");
        bundle.putString("tinhDiem", score + " / " + TongCauHoi);
        //Đưa bundle vào intent
        intent.putExtra("myData", bundle);
        startActivity(intent);
    }


    @Override
    public void onClick(View view) {
        //Đổi màu tất cả các button
        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);

        //Lay về tất cả button
        Button clickedButton = (Button) view;

        //Nếu mà button được click là nút Sau
        if (clickedButton.getId() == R.id.btnCauSau) {
            //Gọi hàm
            handleNextButtonClick();
        }
        //Nếu mà button được click là nút Trước
        else if (clickedButton.getId() == R.id.btnCauTruoc) {
            //Gọi hàm
            handlePreviousButtonClick();
        }
        //Nếu mà button được click là nút Nộp bài
        else if (clickedButton.getId() == R.id.btnNopBai) {
            //Gọi hàm
            handleSubmitButtonClick();
        }
        //Nếu mà button được click là các nút đáp án
        else {
            //Lấy về nội dung của button
            selectedAnswer = clickedButton.getText().toString();
            //Đổi màu button click
            clickedButton.setBackgroundColor(Color.RED);
        }

    }

    //Hàm Load câu hỏi mới
    private void loadNewQuestion() {

        //Hiển thị nội dung câu hỏi
        question.setText(QuestionAnswerTiengViet.question[viTriCauHoiHienTai]);
        //Hiển thị nội dung đáp án
        ansA.setText(QuestionAnswerTiengViet.choices[viTriCauHoiHienTai][0]);
        ansB.setText(QuestionAnswerTiengViet.choices[viTriCauHoiHienTai][1]);
        ansC.setText(QuestionAnswerTiengViet.choices[viTriCauHoiHienTai][2]);
        ansD.setText(QuestionAnswerTiengViet.choices[viTriCauHoiHienTai][3]);

        // Kiểm tra và cập nhật trạng thái của nút "Câu trước"
        if (viTriCauHoiHienTai == 0) {
            btnCauTruoc.setEnabled(false);
        } else {
            btnCauTruoc.setEnabled(true);
        }

        // Kiểm tra và cập nhật trạng thái của nút "Câu sau"
        if (viTriCauHoiHienTai == TongCauHoi - 1) {
            btnCauSau.setEnabled(false);
        } else {
            btnCauSau.setEnabled(true);
        }
    }


}