package av.xxx.qunyingzhuantest.fragmentForCh6;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import av.xxx.qunyingzhuantest.R;
import butterknife.Bind;
import butterknife.ButterKnife;


public class ScratchCardFragment extends Fragment {
    @Bind(R.id.iv)
    ImageView mImageView;
    @Bind(R.id.iv2)
    ImageView mImageView2;
    private Bitmap roundPicByShader;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_scratch_card, container, false);
        ButterKnife.bind(this, view);


        Bitmap bitmap = getRoundPicByXfermode();

        Bitmap bitmap2 =getRoundPicByShader();

        mImageView.setImageBitmap(bitmap);

        mImageView2.setImageBitmap(bitmap2);

        return view;
    }

    private Bitmap getRoundPicByXfermode() {

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.head1);
        Bitmap out = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(out);

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        canvas.drawCircle(bitmap.getWidth() / 2, bitmap.getHeight() / 2, Math.min(bitmap.getWidth() / 2, bitmap.getHeight() / 2), paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

        canvas.drawBitmap(bitmap, 0, 0, paint);

        return out;

    }


    public Bitmap getRoundPicByShader() {

        Bitmap bitmap=BitmapFactory.decodeResource(getResources(),R.mipmap.head2);
        Bitmap out = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        BitmapShader bitmapShader=new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);

        Paint paint=new Paint();
        paint.setAntiAlias(true);
        paint.setShader(bitmapShader);

        Canvas canvas=new Canvas(out);

        canvas.drawCircle(bitmap.getWidth()/2,bitmap.getHeight()/2,Math.min(bitmap.getWidth()/2,bitmap.getHeight()/2),paint);

        return out;
    }
}
