package com.linhchi.interf;

import com.linhchi.object.Story;

public interface IStory {
    void onclick(int position);
    Story getData(int position);
    int getCount();
}
