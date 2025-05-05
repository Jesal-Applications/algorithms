from random import random

from python.helper.Helper import *


class BinarySearch:
    def __init__(self, arr):
        self.arr = arr
        self.num_checks = []

    def search(self, target_index):
        """Performs binary search for the value at target_index and logs number of checks."""
        target_value = self.arr[target_index]
        low, high = 0, len(self.arr) - 1
        checks = 0

        while low <= high:
            checks += 1
            mid = (low + high) // 2
            if self.arr[mid] == target_value:
                self.num_checks.append(checks)
                return
            elif self.arr[mid] < target_value:
                low = mid + 1
            else:
                high = mid - 1

    def average_checks(self):
        """Calculates average number of checks."""
        return sum(self.num_checks) / len(self.num_checks)


def run_binary_search_experiment(runs=5, trials_per_run=100_000):
    """
    Runs the binary search experiment for increasing powers of 2.
    """
    for i in range(2, runs + 1):
        size = 2 ** i
        arr = Helper.generate_int_array(size)
        searcher = BinarySearch(arr)

        for _ in range(trials_per_run):
            random_index = random.randint(0, size - 1)
            searcher.search(random_index)

        print(f"n: {size}\tMax Checks (log2(n)): {Helper.log2(size)}"
              f"\tAverage Checks: {searcher.average_checks():.2f}")