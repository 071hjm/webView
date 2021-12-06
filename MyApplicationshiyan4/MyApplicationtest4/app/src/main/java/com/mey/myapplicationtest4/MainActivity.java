package com.mey.myapplicationtest4;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "hjm";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bn = findViewById(R.id.bn);
        final EditText editText =findViewById(R.id.editText);

        //为bn按钮添加一个监听器
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建Intent
                Intent intent = new Intent();
                //获取editText中输入的数据
                String data = editText.getText().toString();
//                Log.e(TAG, "onClick: "+ data );
                if( data.equals("")){
//                    Log.e(TAG, "onClick: "+ data );
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setIcon(R.mipmap.ic_launcher)
                            .setTitle("警告")
                            .setMessage("输入框不能为空！")
                            .create()
                            .show();
                }else {
                    if( data.indexOf("h") != 0 ){
                        data = "http://" +data;
                    }
                        //根据指定字符串解析出Uri对象
                        Uri uri = Uri.parse(data);
                        //为Intent设置Action属性
                        intent.setAction(Intent.ACTION_VIEW);
                        //为Intent设置Category属性
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
                        //设置Data属性
                        intent.setData(uri);
                        //启动Activity
                        startActivity(intent);
                }
            }
        });
        Button bn_baidu = findViewById(R.id.bn_baidu);
        bn_baidu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建Intent
                Intent intent = new Intent();
                //根据指定字符串解析出Uri对象
                Uri uri = Uri.parse("http://www.baidu.com");
                //为Intent设置Action属性
                intent.setAction(Intent.ACTION_VIEW);
                //为Intent设置Category属性
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                //设置Data属性
                intent.setData(uri);
                //启动Activity
                startActivity(intent);

            }
        });
        Button bn_taobao = findViewById(R.id.bn_taobao);
        bn_baidu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建Intent
                Intent intent = new Intent();
                //根据指定字符串解析出Uri对象
                Uri uri = Uri.parse("http://www.taobao.com");
                //为Intent设置Action属性
                intent.setAction(Intent.ACTION_VIEW);
                //为Intent设置Category属性
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                //设置Data属性
                intent.setData(uri);
                //启动Activity
                startActivity(intent);

            }
        });
    }
}


