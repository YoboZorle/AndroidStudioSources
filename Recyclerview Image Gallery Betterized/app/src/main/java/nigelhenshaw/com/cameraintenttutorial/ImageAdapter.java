package nigelhenshaw.com.cameraintenttutorial;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by nigelhenshaw on 25/06/2015.
 */
public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    //private File imagesFile;
    private File[] mImageFiles;

    public ImageAdapter(File[] folderFile) {
        mImageFiles = folderFile;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gallery_images_relative_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //File imageFile = imagesFile.listFiles()[position];
        File imageFile = mImageFiles[position];
        Bitmap imageBitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath());
        holder.getImageView().setImageBitmap(imageBitmap);
    }

    @Override
    public int getItemCount() {
        //return imagesFile.listFiles().length;
        return mImageFiles.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        public ViewHolder(View view) {
            super(view);

            imageView = (ImageView) view.findViewById(R.id.imageGalleryView);
        }

        public ImageView getImageView() {
            return imageView;
        }
    }

}
