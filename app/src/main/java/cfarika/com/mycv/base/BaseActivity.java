package cfarika.com.mycv.base;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import cn.bmob.v3.Bmob;

/**
 * Created by arika on 16/4/11.
 */
public abstract class BaseActivity extends Activity implements View.OnClickListener {
    private String bombAppId= "276038cd0b7e632fc6e9aa2769aeda14";
    Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(this, bombAppId);
    }

    public void showToast(String text){
        if(!TextUtils.isEmpty(text)){
            if(mToast == null){
                mToast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);
            } else {
                mToast.setText(text);
            }
            mToast.show();
        }

    }

}
