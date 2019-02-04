package top.spencercjh.crabscore.company.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


/**
 * @author spencercjh
 */
@Log4j2
@Configuration
public class DruidConfiguration {

    /**
     * 注册一个DruidDataSource 参数来源于@ConfigurationProperties(prefix = "spring.datasource")
     *
     * @return DataSource
     */
    @SuppressWarnings("ContextJavaBeanUnresolvedMethodsInspection")
    @Bean(destroyMethod = "close", initMethod = "init")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        log.debug("加载DruidDataSource");
        return new DruidDataSource();
    }

    @Value("${spring.datasource.druid.stat-view-servlet.enabled}")
    private String statViewServletEnabled;
    @Value("${spring.datasource.druid.stat-view-servlet.url-pattern}")
    private String statViewServletUrlPattern;
    @Value("${spring.datasource.druid.stat-view-servlet.reset-enable}")
    private String statViewServletResetEnable;
    @Value("${spring.datasource.druid.stat-view-servlet.login-username}")
    private String statViewServletLoginUsername;
    @Value("${spring.datasource.druid.stat-view-servlet.login-password}")
    private String statViewServletLoginPassword;
    @Value("${spring.datasource.druid.stat-view-servlet.allow}")
    private String statViewServletAllow;
    @Value("${spring.datasource.druid.stat-view-servlet.deny}")
    private String statViewServletDeny;
    @Value("${jasypt.encryptor.password}")
    private String jasyptPassword;

    /**
     * 注册一个StatViewServlet 对应配置中spring.datasource.druid.stat-view-servlet的相关配置
     *
     * @return ServletRegistrationBean<StatViewServlet>
     */
    @Bean
    public ServletRegistrationBean<StatViewServlet> druidStatViewServlet() {
        ServletRegistrationBean<StatViewServlet> servletRegistrationBean = new ServletRegistrationBean<>(
                new StatViewServlet(), statViewServletUrlPattern);
        log.debug("加载Druid监视Servlet");
        servletRegistrationBean.addInitParameter("enabled", statViewServletEnabled);
        servletRegistrationBean.addInitParameter("allow", statViewServletAllow);
        servletRegistrationBean.addInitParameter("deny", statViewServletDeny);
        servletRegistrationBean.addInitParameter("loginUsername", statViewServletLoginUsername);
        servletRegistrationBean.addInitParameter("loginPassword", statViewServletLoginPassword);
        servletRegistrationBean.addInitParameter("resetEnable", statViewServletResetEnable);
        return servletRegistrationBean;
    }

    @Value("${spring.datasource.druid.web-stat-filter.url-pattern}")
    private String webStatFilterUrlPattern;
    @Value("${spring.datasource.druid.web-stat-filter.exclusions}")
    private String webStatFilterExclusions;
    @Value("${spring.datasource.druid.web-stat-filter.enabled}")
    private String webStatFilterEnabled;
    @Value("${spring.datasource.druid.web-stat-filter.profile-enable}")
    private String webStatFilterProfileEnable;

    /**
     * 注册一个：filterRegistrationBean 对应配置中spring.datasource.druid.web-stat-filter的相关配置
     *
     * @return FilterRegistrationBean<WebStatFilter>
     */
    @Bean
    public FilterRegistrationBean<WebStatFilter> druidStatFilter() {
        FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<>(new WebStatFilter());
        log.debug("加载Druid过滤器Filter");
        filterRegistrationBean.addUrlPatterns(webStatFilterUrlPattern);
        filterRegistrationBean.addInitParameter("exclusions", webStatFilterExclusions);
        filterRegistrationBean.addInitParameter("enabled", webStatFilterEnabled);
        filterRegistrationBean.addInitParameter("profile-enable", webStatFilterProfileEnable);
        return filterRegistrationBean;
    }

}