package com.gll.gllandroidstudy.utils;

/**
 * Created by ZhouBin on 2017/8/7.
 * Effect: 存放常量信息
 */

public interface ConstantValue {

    String POSITION = "postion";
    String TITLE = "title";
    String URL = "url";
    String USER_NAME = "username";
    String MOBILE = "mobile";
    String NUMBER = "number";
    String CODE = "code";
    String ID = "id"; //登录的账户的id
    String BALANCE = "balance"; //余额
    String PRICE = "price";
    String USER_INFO = "user_info";
    String TYPE = "type";
    String INDEX = "index";
    String SIGN_KEY = "sign";
    int VP_TURN_TIME = 5000;//banner轮播时间

    String[] imageList = {
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516872514891&di=cfa01043976865f8d17867da6da636bc&imgtype=0&src=http%3A%2F%2Fpic3.16pic.com%2F00%2F00%2F91%2F16pic_91499_b.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516872514885&di=9ab37395998f3ffd78e37c5360e03d79&imgtype=0&src=http%3A%2F%2Fimg1.cache.netease.com%2Fcatchpic%2FD%2FDD%2FDD59359C1F07AD5024E62FA6DA1605A0.jpg",
            "https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1516862427&di=b86dd39002febd7090b53fcb64e14323&src=http://img4.duitang.com/uploads/blog/201404/27/20140427225617_GGKAH.thumb.700_0.jpeg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516872553291&di=f2d3b638e50beb3d353593e8faa563e5&imgtype=jpg&src=http%3A%2F%2Fimg2.imgtn.bdimg.com%2Fit%2Fu%3D3191248617%2C1635470861%26fm%3D214%26gp%3D0.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516872514891&di=a7456dc8689a070ed45deda3244c784f&imgtype=0&src=http%3A%2F%2Fimg06.tooopen.com%2Fimages%2F20170221%2Ftooopen_sy_199240913125.jpg"
    };

    String[] videoUrl = {
            "http://jzvd.nathen.cn/6ea7357bc3fa4658b29b7933ba575008/fbbba953374248eb913cb1408dc61d85-5287d2089db37e62345123a1be272f8b.mp4",
            "http://jzvd.nathen.cn/35b3dc97fbc240219961bd1fccc6400b/8d9b76ab5a584bce84a8afce012b72d3-5287d2089db37e62345123a1be272f8b.mp4",
            "http://jzvd.nathen.cn/df6096e7878541cbbea3f7298683fbed/ef76450342914427beafe9368a4e0397-5287d2089db37e62345123a1be272f8b.mp4",
            "http://jzvd.nathen.cn/384d341e000145fb82295bdc54ecef88/103eab5afca34baebc970378dd484942-5287d2089db37e62345123a1be272f8b.mp4",
            "http://jzvd.nathen.cn/f55530ba8a59403da0621cbf4faef15e/adae4f2e3ecf4ea780beb057e7bce84c-5287d2089db37e62345123a1be272f8b.mp4",
            "http://jzvd.nathen.cn/6340efd1962946ad80eeffd19b3be89c/65b499c0f16e4dd8900497e51ffa0949-5287d2089db37e62345123a1be272f8b.mp4",
            "http://jzvd.nathen.cn/f07fa9fddd1e45a6ae1570c7fe7967c1/c6db82685b894e25b523b1cb28d79f2e-5287d2089db37e62345123a1be272f8b.mp4",
            "http://jzvd.nathen.cn/d2e969f2ec734520b46ab0965d2b68bd/f124edfef6c24be8b1a7b7f996ccc5e0-5287d2089db37e62345123a1be272f8b.mp4",
            "http://jzvd.nathen.cn/4f965ad507ef4194a60a943a34cfe147/32af151ea132471f92c9ced2cff785ea-5287d2089db37e62345123a1be272f8b.mp4",
            "http://jzvd.nathen.cn/342a5f7ef6124a4a8faf00e738b8bee4/cf6d9db0bd4d41f59d09ea0a81e918fd-5287d2089db37e62345123a1be272f8b.mp4",
            "http://jzvd.nathen.cn/623f75c3beea4b1781ea37940e70bbe4/b9cee3fd1a09487ca99ef789cdc41312-5287d2089db37e62345123a1be272f8b.mp4",
            "http://jzvd.nathen.cn/d8c137ceba9849f8b2f454a55a96266f/910c8381ff894905b5bc272f8194382a-5287d2089db37e62345123a1be272f8b.mp4",
            "http://jzvd.nathen.cn/b8a589e5f12c45fdad96674d08affd31/f1d7229f553f414283033af3e292c6c9-5287d2089db37e62345123a1be272f8b.mp4",
            "http://jzvd.nathen.cn/8abcdf98ec6a418b945a70fe9dd6fc7f/5cb36416a23a4da8b15d3eaa5e19a1e6-5287d2089db37e62345123a1be272f8b.mp4",
            "http://jzvd.nathen.cn/1b61da23555d4ce28c805ea303711aa5/7a33ac2af276441bb4b9838f32d8d710-5287d2089db37e62345123a1be272f8b.mp4",
            "http://jzvd.nathen.cn/d525f756aabf4b0588c2152fb94e07f5/d9f59bef829a472a9ca066620d9b871a-5287d2089db37e62345123a1be272f8b.mp4",
            "http://jzvd.nathen.cn/6e2fdec45dfa44a6802e95f8e4bc3280/a6a5273ac4244333923991be0583ffc7-5287d2089db37e62345123a1be272f8b.mp4",
            "http://jzvd.nathen.cn/22b4de0e2b1245959c5baa77fe0bf14e/896a137559084b7eb879f5441faff20d-5287d2089db37e62345123a1be272f8b.mp4"

    };
    String[] videoThumbs =
            {
                    "http://jzvd-pic.nathen.cn/jzvd-pic/bd7ffc84-8407-4037-a078-7d922ce0fb0f.jpg",
                    "http://jzvd-pic.nathen.cn/jzvd-pic/f2dbd12e-b1cb-4daf-aff1-8c6be2f64d1a.jpg",
                    "http://jzvd-pic.nathen.cn/jzvd-pic/ccd86ca1-66c7-4331-9450-a3b7f765424a.png",
                    "http://jzvd-pic.nathen.cn/jzvd-pic/2adde364-9be1-4864-b4b9-0b0bcc81ef2e.jpg",
                    "http://jzvd-pic.nathen.cn/jzvd-pic/2a877211-4b68-4e3a-87be-6d2730faef27.png",
                    "http://jzvd-pic.nathen.cn/jzvd-pic/aaeb5da9-ac50-4712-a28d-863fe40f1fc6.png",
                    "http://jzvd-pic.nathen.cn/jzvd-pic/e565f9cc-eedc-45f0-99f8-5b0fa3aed567%281%29.jpg",
                    "http://jzvd-pic.nathen.cn/jzvd-pic/3430ec64-e6a7-4d8e-b044-9d408e075b7c.jpg",
                    "http://jzvd-pic.nathen.cn/jzvd-pic/2204a578-609b-440e-8af7-a0ee17ff3aee.jpg",
                    "http://jzvd-pic.nathen.cn/jzvd-pic/1bb2ebbe-140d-4e2e-abd2-9e7e564f71ac.png",
                    "http://jzvd-pic.nathen.cn/jzvd-pic/f18ee453-6aec-40a5-a046-3203111dd303.jpg",
                    "http://jzvd-pic.nathen.cn/jzvd-pic/00f5a243-1e9f-426c-94f4-888971987edb.jpg",
                    "http://jzvd-pic.nathen.cn/jzvd-pic/7df34ee9-1e4f-48f4-8acd-748c52368298.jpg",
                    "http://jzvd-pic.nathen.cn/jzvd-pic/ef46e139-e378-4298-8441-144888294f1f.png",
                    "http://jzvd-pic.nathen.cn/jzvd-pic/0e58101d-5b47-4100-8fb3-0cce057fd622.jpg",
                    "http://jzvd-pic.nathen.cn/jzvd-pic/d6d3a520-b183-4867-8746-5b6aba6c1724.png",
                    "http://jzvd-pic.nathen.cn/jzvd-pic/caa3dade-5744-486d-a1b7-9780aebb9eb5.jpg",
                    "http://jzvd-pic.nathen.cn/jzvd-pic/2c3e62bb-6a32-4fb0-a1d5-d1260ad436a4.png"
            };

    String[] imageThumbUrls = {
            "http://img.mukewang.com/55237dcc0001128c06000338.jpg",
            "http://img.mukewang.com/55249cf30001ae8a06000338.jpg",
            "http://img.mukewang.com/5523711700016d1606000338.jpg",
            "http://img.mukewang.com/551e470500018dd806000338.jpg",
            "http://img.mukewang.com/551de0570001134f06000338.jpg",
            "http://img.mukewang.com/552640c300018a9606000338.jpg",
            "http://img.mukewang.com/551b92340001c9f206000338.jpg",
            "http://img.mukewang.com/5518c3d7000175af06000338.jpg",
            "http://img.mukewang.com/551b98ae0001e57906000338.jpg",
            "http://img.mukewang.com/550b86560001009406000338.jpg",
            "http://img.mukewang.com/551916790001125706000338.jpg",
            "http://img.mukewang.com/5518ecf20001cb4e06000338.jpg",
            "http://img.mukewang.com/551380400001da9b06000338.jpg",
            "http://img.mukewang.com/550a33b00001738a06000338.jpg",
            "http://img.mukewang.com/5513a1b50001752806000338.jpg",
            "http://img.mukewang.com/5513e20600017c1806000338.jpg",
            "http://img.mukewang.com/5518ecf20001cb4e06000338.jpg",
            "http://img.mukewang.com/551916790001125706000338.jpg",
            "http://img.mukewang.com/550a87da000168db06000338.jpg",
            "http://img.mukewang.com/530f0ef700019b5906000338.jpg",
            "http://img.mukewang.com/549bda090001c53e06000338.jpg",
            "http://img.mukewang.com/547d5a45000156f406000338.jpg",
            "http://img.mukewang.com/54780ea90001f3b406000338.jpg",
            "http://img.mukewang.com/547ed1c9000150cc06000338.jpg",
            "http://img.mukewang.com/54214727000160e306000338.jpg",
            "http://img.mukewang.com/54c87c73000150cf06000338.jpg",
            "http://img.mukewang.com/548165820001b4b006000338.jpg",
    };

}
