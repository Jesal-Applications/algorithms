import math

class Helper:
    @staticmethod
    def generate_int_array(size):
        """Generates a sorted array from 0 to size-1."""
        return list(range(size))

    @staticmethod
    def log2(n):
        """Returns the base-2 logarithm of a number."""
        return int(math.log2(n))