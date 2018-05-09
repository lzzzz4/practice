package cn.dubidubi.base.mysqlrw;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Auther: 16224
 * @Date: 2018/5/9 0009 13:18
 * @Description:扩展spring的数据源路由类
 */
public class RouteDataSource extends AbstractRoutingDataSource {
    //每一个请求对应一个线程
    private static ThreadLocal<String> holder = new ThreadLocal<>();
    @Override
    protected Object determineCurrentLookupKey() {
        return  holder.get();
    }

    /**@description: 设置key
     * @param:
     * @return:
     * @auther: 16224
     * @date: 2018/5/9 0009 13:19
     */
    public static void setDbKey(RouteDataSourceKeyEnum dbKey) {
        holder.set(dbKey.name());
    }
}
