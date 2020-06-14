/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ArrayList<Item> data;
    private int selectedCount=0;
    private boolean [] selected=new boolean[100];

    public MyAdapter(ArrayList<Item> mdata) {
        data = mdata;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView listItemTV;
        CheckBox listItemCB;
        public ViewHolder(View itemView) {
            super(itemView);
            listItemTV = (TextView) itemView.findViewById(R.id.tv_item);
            listItemCB=(CheckBox)itemView.findViewById(R.id.cb_item);
        }
        void bind(int listIndex) {
            listItemTV.setText(data.toString());
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // 連結項目布局檔list_item
        //        View view = LayoutInflater.from(parent.getContext())
        //                .inflate(R.layout.list_item, parent, false);
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.list_item;
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Item items=data.get(position);
        holder.listItemTV.setText(items.getText());
        holder.listItemCB.setChecked(items.isCheck());
        holder.listItemCB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean b = ((CheckBox) view).isChecked();
                holder.listItemCB.setChecked(b);
                data.get(position).setCheck(b);
                if(b){
                    selected[position]=true;
                    selectedCount+=1;
                }else{
                    selectedCount-=1;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public int getSelectedCount(){
        return selectedCount;
    };

    public boolean[] getSelected(){
        return selected;
    }

}
