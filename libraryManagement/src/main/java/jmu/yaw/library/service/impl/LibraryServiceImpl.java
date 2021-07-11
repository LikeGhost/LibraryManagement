package jmu.yaw.library.service.impl;

import jmu.yaw.library.mapper.LibraryMapper;
import jmu.yaw.library.po.Library;
import jmu.yaw.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryServiceImpl implements LibraryService {
    @Autowired
    LibraryMapper libraryMapper;
    @Override
    public Library queryLibraryByLName(Library library) {
        return libraryMapper.queryLibraryByLName(library);
    }
}
