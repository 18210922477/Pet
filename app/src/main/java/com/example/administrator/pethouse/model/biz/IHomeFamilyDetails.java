package com.example.administrator.pethouse.model.biz;

import com.example.administrator.pethouse.model.callback.INetworkcallback;

/**
 * Tap into soulful code @_阿钟 2017/12/21
 */

public interface IHomeFamilyDetails {
    <T> void doFamilyDetails (String userId, INetworkcallback<T> iNetworkcallback);
}
