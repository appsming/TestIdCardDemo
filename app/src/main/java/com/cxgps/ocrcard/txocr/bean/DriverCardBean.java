package com.cxgps.ocrcard.txocr.bean;

import java.util.List;

/**
 * Created by taosong on 2017/12/13.
 */

public class DriverCardBean extends BaseBean{

    public String session_id;
    public List<DriverCardBean.ItemsBean> items;

    public static class ItemsBean {
        public String item;
        public DriverCardBean.ItemsBean.ItemcoordBean itemcoord;
        public double itemconf;
        public String itemstring;
        public List<?> coords;
        public List<?> words;
        public List<?> candword;

        public static class ItemcoordBean {
            public int x;
            public int y;
            public int width;
            public int height;
        }
    }

}
