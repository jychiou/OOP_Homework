package com.senao.oop.file;

import java.util.Iterator;


/**
 * 檔案搜尋的介面
 * 讓使用端可以直接對 FileFinder 做 foreach()
 * @author 014616
 *
 * @param <Candidate>
 */
public interface FileFinder<Candidate> extends Iterable<Candidate>, Iterator<Candidate> {

}
