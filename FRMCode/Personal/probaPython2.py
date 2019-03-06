import unittest
def factorial(n):
    return 1 if n < 1 else n*factorial(n-1)

class tester (unittest.TestCase):
    def test1(self):
        self.assertEquals(1,factorial(0))
    def test2(self):
        self.assertEquals(24,factorial(4))
    def test3(self):
        self.assertEquals(1,factorial(5))
if __name__=="__main__":
    unittest.main()