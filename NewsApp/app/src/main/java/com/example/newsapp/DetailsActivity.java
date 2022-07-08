package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.newsapp.Models.NewsHeadlines;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {
    NewsHeadlines headlines;
    TextView txt_title, txt_author, txt_detail, txt_content, txt_time;
    ImageView img_news;
    Button full_article;
    String txt_article_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        txt_title = findViewById(R.id.text_detail_title);
        txt_author = findViewById(R.id.text_detail_author);
        txt_detail = findViewById(R.id.Text_detail_detail);
        //txt_content = findViewById(R.id.Text_detail_content);
        txt_time = findViewById(R.id.text_detail_time);
        img_news = findViewById(R.id.img_detail_news);
        full_article = findViewById(R.id.Expand_article_webview);


        headlines = (NewsHeadlines) getIntent().getSerializableExtra("data");

        txt_title.setText(headlines.getTitle());
        txt_author.setText(headlines.getAuthor());
        txt_time.setText(headlines.getPublishedAt());
        txt_detail.setText(headlines.getDescription());
        //txt_content.setText(headlines.getContent());
        Picasso.get().load(headlines.getUrlToImage()).into(img_news);
        txt_article_url = headlines.getUrl();

        full_article.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DetailsActivity.this, WebViewActivity.class);
                i.putExtra(WebViewActivity.WEBSITE_ADDRESS, txt_article_url);
                startActivity(i);
            }
        });

    }
}