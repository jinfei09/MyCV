package cfarika.com.mycv;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import cfarika.com.mycv.base.BaseActivity;
import cfarika.com.mycv.bean.Person;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.DeleteListener;
import cn.bmob.v3.listener.GetListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

public class MainActivity extends BaseActivity {

    @InjectView(R.id.btn_add)
    Button btnAdd;
    @InjectView(R.id.btn_update)
    Button btnUpdate;
    @InjectView(R.id.btn_query)
    Button btnQuery;
    @InjectView(R.id.btn_delete)
    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

    }

    @OnClick({R.id.btn_add, R.id.btn_delete, R.id.btn_query, R.id.btn_update})
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_add:
                showToast("ADD");
                createPerson();
                break;
            case R.id.btn_delete:
                deletePersonByObjectId();
                showToast("Delete");
                break;
            case R.id.btn_update:
                showToast("Update");
                updatePersonByObjectId();
                break;
            case R.id.btn_query:
                showToast("Query");
                queryPersonByObjectId();
                break;
            default:
                break;
        }
    }

    private void queryPersonByObjectId() {
        String objId = "acc485e2ab";
        BmobQuery<Person> bmobQuery = new BmobQuery<Person>();
        bmobQuery.getObject(this, objId, new GetListener<Person>() {
            @Override
            public void onSuccess(Person person) {
                showToast("查询成功");
            }

            @Override
            public void onFailure(int i, String s) {
                showToast("查询失败");
            }
        });
    }

    private void updatePersonByObjectId() {
        String objId = "acc485e2ab";
        final Person p2 = new Person();
        p2.setAddress("北京朝阳");
        p2.update(this, objId, new UpdateListener() {
            @Override
            public void onSuccess() {
                showToast("更新成功" + p2.getUpdatedAt());
            }

            @Override
            public void onFailure(int i, String s) {
                showToast("更新失败: " + s);
            }
        });
    }

    private void deletePersonByObjectId() {
        String objId = "acc485e2ab";
        final Person p2 = new Person();
        p2.setObjectId(objId);
        p2.delete(this, new DeleteListener() {
            @Override
            public void onSuccess() {
                showToast("删除成功");
            }

            @Override
            public void onFailure(int i, String s) {
                showToast("删除失败: " + s);
            }
        });
    }

    private void createPerson() {
        final Person p2 = new Person();
        p2.setName("lucky");
        p2.setAddress("beijing");
        p2.save(this, new SaveListener() {
            @Override
            public void onSuccess() {
                showToast("添加数据成功， 返回ObjectId为" + p2.getObjectId());
            }

            @Override
            public void onFailure(int i, String s) {
                showToast("创建数据失败:" + s);
            }
        });
    }
}
