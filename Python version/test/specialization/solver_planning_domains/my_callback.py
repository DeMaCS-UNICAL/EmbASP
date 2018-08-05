import threading
from base.callback import Callback
from languages.pddl.plan import Plan


class MyCallback(Callback):

    def __init__(self, count=1):
        self.count = count
        self.lock = threading.Condition()
        self.ans = None

    def __count_down(self):
        self.lock.acquire()
        self.count -= 1
        if self.count <= 0:
            self.lock.notifyAll()
        self.lock.release()

    def await(self):
        self.lock.acquire()
        while self.count > 0:
            self.lock.wait()
        self.lock.release()

    def callback(self, o):
        if not isinstance(o, Plan):
            return
        self.ans = o
        self.__count_down()

    def get_output(self):
        return self.ans
