import doctest
def factorial(n):
    """
    >>> factorial(0)
    1
    >>> factorial(4)
    24
    >>> factorial(5)
    121
    """

    return 1 if n < 1 else n*factorial(n-1)
if __name__=="__main__":
    doctest.testmod()