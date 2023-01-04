package com.suivibu.main.security;

import java.util.HashSet;
import java.util.Set;

public final class TokenWarehouse {
	
    private static Set<String> revokedTokens = new HashSet<>();
    
    private TokenWarehouse()
    {}
    
    public static Set<String> getRevokedTokens()
    {
    	return revokedTokens;
    }
    

}
