package test.dev.axon.com.adgtestwork;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import test.dev.axon.com.adgtestwork.entity.User;

public class UserAdapter extends ArrayAdapter<User>{
    List<User> contactList;
    Context context;
    private LayoutInflater mInflater;

    // Constructors
    public UserAdapter(Context context, List<User> objects) {
        super(context, 0, objects);
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        contactList = objects;
    }

    @Override
    public User getItem(int position) {
        return contactList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder vh;
        if (convertView == null) {
            View view = mInflater.inflate(R.layout.item_user, parent, false);
            vh = ViewHolder.create((RelativeLayout) view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        User item = getItem(position);


        //set name
        vh.textViewName.setText(item.getName().first + " " + item.getName().last);


        //set photo
        Picasso.with(context).load(item.getPicture().medium).placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_background).into(vh.imageView);

        return vh.rootView;
    }

    private static class ViewHolder {
        public final RelativeLayout rootView;
        public final ImageView imageView;
        public final TextView textViewName;


        private ViewHolder(RelativeLayout rootView, ImageView imageView, TextView textViewName) {
            this.rootView = rootView;
            this.imageView = imageView;
            this.textViewName = textViewName;

        }

        public static ViewHolder create(RelativeLayout rootView) {
            ImageView imageView = (ImageView) rootView.findViewById(R.id.imageView);
            TextView textViewName = (TextView) rootView.findViewById(R.id.textViewName);


            return new ViewHolder(rootView, imageView, textViewName);
        }

    }
}
