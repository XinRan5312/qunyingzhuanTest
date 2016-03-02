package av.xxx.qunyingzhuantest.fragmentForCh6;

import android.support.v4.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;

import av.xxx.qunyingzhuantest.R;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 1 on 2016/2/17.
 */
public class ColorMatrixFragment extends Fragment implements SeekBar.OnSeekBarChangeListener {
    @Bind(R.id.sb_0)
    SeekBar mHueSeek;
    @Bind(R.id.sb_1)
    SeekBar mStaurationSeek;
    @Bind(R.id.sb_2)
    SeekBar mLumSeek;
    @Bind(R.id.iv)
    ImageView mImage;

    private float mHue=0;
    private float mStauration=1;
    private float mLum=1;

    Bitmap mBitmap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_color_matrix, container, false);
        ButterKnife.bind(this, view);
        mHueSeek.setProgress(50);
        mStaurationSeek.setProgress(50);
        mLumSeek.setProgress(50);
        mHueSeek.setOnSeekBarChangeListener(this);
        mStaurationSeek.setOnSeekBarChangeListener(this);
        mLumSeek.setOnSeekBarChangeListener(this);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.image_sea);
        return view;
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()) {
            case R.id.sb_0:
                mHue = (progress - 50) * 1.0f / 50 * 180;
                break;
            case R.id.sb_1:
                mStauration = progress * 1.0f / 50;
                break;
            case R.id.sb_2:
                mLum = progress * 1.0f / 50;
                break;

        }

        mImage.setImageBitmap(handleImageEffect(mBitmap, mHue, mStauration, mLum));
    }

    private Bitmap handleImageEffect(Bitmap bm, float hue, float saturation, float lum) {
        Bitmap bmp = Bitmap.createBitmap(bm.getWidth(), bm.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmp);
        Paint paint = new Paint();

        ColorMatrix hueMatrix = new ColorMatrix();
        hueMatrix.setRotate(0, hue);
        hueMatrix.setRotate(1, hue);
        hueMatrix.setRotate(2, hue);

        ColorMatrix saturationMatrix = new ColorMatrix();
        saturationMatrix.setSaturation(saturation);

        ColorMatrix lumMatrix = new ColorMatrix();
        lumMatrix.setScale(lum, lum, lum, 1);

        ColorMatrix matrix = new ColorMatrix();
        matrix.postConcat(hueMatrix);
        matrix.postConcat(saturationMatrix);
        matrix.postConcat(lumMatrix);

        paint.setColorFilter(new ColorMatrixColorFilter(matrix));
        canvas.drawBitmap(bm, 0, 0, paint);
        //ϵͳ�������޸�ԭͼ  �������ͨ��ԭͼ������һ���µ�bitmap���Ը�������ʽ���޸�ͼƬ
        return bmp;
    }


    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {


        

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}