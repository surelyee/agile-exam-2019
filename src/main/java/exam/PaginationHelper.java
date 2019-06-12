package exam;

import java.util.List;

// TODO: 完成这个类

public class PaginationHelper<I> {
    private List<I> collection;
    private int itemsPerPage;


    /**
     * 构造函数包含
     * 1）数组collection，表示需要分页的所有元素
     * 2）数字itemsPerPage，表示每页的元素个数
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.collection = collection;
        this.itemsPerPage = itemsPerPage;
    }

    /**
     * 返回collection中所有元素的个数
     */
    public int itemCount() {
        return collection.size();
    }

    /**
     * 返回页数
     */
    public int pageCount() {
        int totalCount = itemCount();
        int pagecount = 0;
        if (itemsPerPage == 0) {
            throw new RuntimeException();
        }
        int m = itemCount() % itemsPerPage;
        if (m > 0) {
            pagecount = totalCount / itemsPerPage + 1;
        } else {
            pagecount = totalCount / itemsPerPage;
        }
        return pagecount;
    }

    /**
     * 返回当前页pageIndex中所包含的元素个数
     * pageIndex从0开始计数
     * 如果pageIndex为非法值则返回-1
     */
    public int pageItemCount(int pageIndex) {
        int pageCount = pageCount();
        if (pageIndex < 0 || pageIndex>=pageCount) {
            return -1;
        }
        if (pageIndex != pageCount - 1) {
            return itemsPerPage;
        }


        return itemCount() - pageIndex * itemsPerPage;

    }

    /**
     * 返回第itemIndex个元素所在的页数
     * pageIndex从0开始计数
     * 如果itemIndex为非法值则返回-1
     */
    public int pageIndex(int itemIndex) {
        int totalCount = itemCount();
        if (itemIndex >= totalCount || itemIndex < 0) {
            return -1;
        }
        int page = 0;
        itemIndex += 1;
        while (itemIndex - itemsPerPage >= 0) {
            page++;
            itemIndex -= itemsPerPage;
        }
        return page;
    }


}