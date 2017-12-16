package teknologi.azha.portaldebitur.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import teknologi.azha.portaldebitur.R;
import teknologi.azha.portaldebitur.model.MenuModel;
import teknologi.azha.portaldebitur.ui.listerner.OnItemClickListener;

/**
 * Created by user on 11/2/2017.
 */

public class MenuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context mContext;
    private OnItemClickListener onClickListener;

    private List<MenuModel> list;

    public MenuAdapter(List<MenuModel> list) {
        this.list = list;
    }

    public MenuModel getSelectedItem(int position) {
        return list.get(position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onClickListener = listener;
    }

    public OnItemClickListener onItemClickListener() {
        return new OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, View view, int position, long id) {
                if (onClickListener != null) {
                    onClickListener.onItemClick(itemView, view, position, id);
                }
            }

        };
    }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            mContext = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(mContext);
            return getMenuViewHolder(inflater, parent);
        }

        private RecyclerView.ViewHolder getMenuViewHolder(LayoutInflater inflater, ViewGroup parent) {
            View v = inflater.inflate(R.layout.item_menu_navigation1, parent, false);
            MenuViewHolder viewHolder = new MenuViewHolder(v);
            viewHolder.setOnClickListener(onItemClickListener());
            return viewHolder;
        }

        @Override
        public int getItemViewType(int position) {
            return list.get(position).getType();
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            try {
                boolean isLastItem = position == list.size() - 1;
                MenuModel model = list.get(position);
                if (model.getType() == 0 && holder instanceof MenuViewHolder) {
                    MenuViewHolder newHolder = (MenuViewHolder) holder;
                    newHolder.tvMenu.setText(model.getLabel());
                    if (newHolder.ivIcon != null && model.getIcon() != null) {
                        newHolder.ivIcon.setImageDrawable(model.getIcon());
                    }
                }
            } catch (Exception e) {

            }
                }
        @Override
        public int getItemCount() {
                return list != null ? list.size() : 0;
                }
}
