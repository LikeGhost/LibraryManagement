package jmu.yaw.library.mapper;

import jmu.yaw.library.po.Library;

public interface LibraryMapper {
    Library queryLibraryByLName(Library library);
}
