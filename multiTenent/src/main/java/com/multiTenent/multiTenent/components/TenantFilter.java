package com.multiTenent.multiTenent.components;

import com.multiTenent.multiTenent.service.StoreService;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class TenantFilter implements Filter {

    @Autowired
    private StoreService storeService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        String tenantId = ((HttpServletRequest) request).getHeader("X-Tenant-ID");
        // uuid for tenant will be sent from client X-Tenant-ID


        // get store id from store using this uuid
        // long,

        try {
            Long storeId = storeService.getStoreId(tenantId);
            TenantContext.setCurrentTenant(storeId);
            chain.doFilter(request, response);
        }catch (Exception e){
            throw new ServletException("Invalid Tenant Id");
        }finally {
            TenantContext.clear();
        }
  }

    private String retrieveTenantIdFromRequest(ServletRequest request) {
        return "defaultTenant";
    }
}
