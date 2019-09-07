package ntk.android.ticketing.activity;

import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import es.dmoral.toasty.Toasty;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ntk.android.ticketing.R;
import ntk.android.ticketing.adapter.AdBlog;
import ntk.android.ticketing.config.ConfigRestHeader;
import ntk.android.ticketing.config.ConfigStaticValue;
import ntk.android.ticketing.utill.AppUtill;
import ntk.android.ticketing.utill.FontManager;
import ntk.base.api.blog.interfase.IBlog;
import ntk.base.api.blog.model.BlogContent;
import ntk.base.api.blog.model.BlogContentListRequest;
import ntk.base.api.blog.model.BlogContentListResponse;
import ntk.base.api.model.Filters;
import ntk.base.api.utill.NTKUtill;
import ntk.base.api.utill.RetrofitManager;

public class ActBlogSearch extends AppCompatActivity {

    @BindView(R.id.txtSearchActBlogSearch)
    EditText Txt;

    @BindView(R.id.recyclerBlogSearch)
    RecyclerView Rv;

    @BindView(R.id.btnRefreshActBlogSearch)
    Button btnRefresh;

    @BindView(R.id.mainLayoutActBlogSearch)
    CoordinatorLayout layout;

    private ArrayList<BlogContent> blogs = new ArrayList<>();
    private AdBlog adapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_blog_search);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        Rv.setHasFixedSize(true);
        Rv.setLayoutManager(new GridLayoutManager(this, 2));

        Txt.setTypeface(FontManager.GetTypeface(this, FontManager.IranSans));
        Txt.setOnEditorActionListener((textView, i, keyEvent) -> {
            if (i == EditorInfo.IME_ACTION_SEARCH) {
                Search();
                return true;
            }
            return false;
        });
        adapter = new AdBlog(this, blogs);
        Rv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void Search() {
        if (AppUtill.isNetworkAvailable(this)) {
            RetrofitManager manager = new RetrofitManager(this);
            IBlog iBlog = manager.getRetrofitUnCached(new ConfigStaticValue(this).GetApiBaseUrl()).create(IBlog.class);

            BlogContentListRequest request = new BlogContentListRequest();
            List<Filters> filters = new ArrayList<>();
            Filters ft = new Filters();
            ft.PropertyName = "Title";
            ft.StringValue1 = Txt.getText().toString();
            ft.ClauseType = NTKUtill.ClauseType_Or;
            ft.SearchType = NTKUtill.Search_Type_Contains;
            filters.add(ft);

            Filters fd = new Filters();
            fd.PropertyName = "Description";
            fd.StringValue1 = Txt.getText().toString();
            fd.ClauseType = NTKUtill.ClauseType_Or;
            fd.SearchType = NTKUtill.Search_Type_Contains;
            filters.add(fd);

            Filters fb = new Filters();
            fb.PropertyName = "Body";
            fb.StringValue1 = Txt.getText().toString();
            fb.ClauseType = NTKUtill.ClauseType_Or;
            fb.SearchType = NTKUtill.Search_Type_Contains;

            filters.add(fb);
            request.filters = filters;

            Observable<BlogContentListResponse> Call = iBlog.GetContentList(new ConfigRestHeader().GetHeaders(this), request);
            Call.observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new Observer<BlogContentListResponse>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(BlogContentListResponse response) {
                            if (response.IsSuccess) {
                                if (response.ListItems.size() != 0) {
                                    blogs.addAll(response.ListItems);
                                    adapter.notifyDataSetChanged();
                                } else {
                                    Toasty.warning(ActBlogSearch.this, "نتیجه ای یافت نشد", Toasty.LENGTH_LONG, true).show();
                                }
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            btnRefresh.setVisibility(View.VISIBLE);
                            Snackbar.make(layout, "عدم دسترسی به اینترنت", Snackbar.LENGTH_INDEFINITE).setAction("تلاش مجددا", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    init();
                                }
                            }).show();
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        } else {
            btnRefresh.setVisibility(View.VISIBLE);
            Toasty.warning(this, "عدم دسترسی به اینترنت", Toasty.LENGTH_LONG, true).show();
        }
    }

    @OnClick(R.id.imgBackActBlogSearch)
    public void ClickBack() {
        finish();
    }

    @OnClick(R.id.btnRefreshActBlogSearch)
    public void ClickRefresh() {
        btnRefresh.setVisibility(View.GONE);
        init();
    }
}