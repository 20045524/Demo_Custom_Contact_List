package sg.edu.rp.c346.id20045524.democustomcontactlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Contact> contactList;

    public CustomAdapter(Context context, int resource, ArrayList<Contact> objects) {
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        contactList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object - Get
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row - Read
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding - Find and Bind
        TextView tvName = rowView.findViewById(R.id.textViewName);
        TextView tvCode = rowView.findViewById(R.id.textViewCountryCode);
        TextView tvNum = rowView.findViewById(R.id.textViewPhoneNum);
        ImageView ivGender = rowView.findViewById(R.id.imageViewGender);
        ImageView ivFlag = rowView.findViewById(R.id.ivFlag);

        // Obtain the Contact information based on the position - Find
        Contact currentItem = contactList.get(position);

        // Set values to the TextView to display the corresponding information - Populate
        tvName.setText(currentItem.getName());
        tvCode.setText("+" + currentItem.getCountryCode());
        tvNum.setText(currentItem.getPhoneNum()+ "");


        String imageUrl = "";
        if (String.valueOf(currentItem.getGender()).equalsIgnoreCase("F")){
            imageUrl += "https://upload.wikimedia.org/wikipedia/commons/thumb/2/24/Venus-female-symbol-pseudo-3D-pink.svg/1229px-Venus-female-symbol-pseudo-3D-pink.svg.png";
            //ivGender.setImageResource(R.drawable.female);
        } else {
            imageUrl += "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4f/Mars-male-symbol-pseudo-3D-blue.svg/1200px-Mars-male-symbol-pseudo-3D-blue.svg.png";
            //ivGender.setImageResource(R.drawable.male);
        }
        Picasso.with(parent_context).load(imageUrl).into(ivGender);

        String fileImageUrl = "https://cdn.countryflags.com/thumbs/singapore/flag-3d-round-500.png";
        Picasso.with(parent_context).load(fileImageUrl).into(ivFlag);


        return rowView;
    }



}
