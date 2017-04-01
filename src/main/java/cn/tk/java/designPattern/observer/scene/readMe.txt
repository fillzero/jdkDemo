设计一个发布-订阅场景

Boss --> Jack
    ArrayList<Staff>
    employ(Staff staff)
    fire(Staff staff)
    haveAMeeting()

Staff --> Amy 、Sam、LiLi
    doSomething()

Amy
    doSomething()
Sam
    doSomething()
LiLi
    doSomething()

Test
    Jack
        employ(staffA)
        employ(staffB)
        employ(staffC)
         haveAMeeting()
    Amy is coming;
    Sam is coming;
    LiLi is coming;
