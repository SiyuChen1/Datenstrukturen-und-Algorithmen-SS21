import numpy as np
import matplotlib.pyplot as plt
from scipy.special import factorial

x = np.arange(1,30,0.1)   # start,stop,step
y_1 = np.exp2(x)
y_2 = np.log2(x)
y_3 = x
y_4 = factorial(x, exact=False)
y_5 = np.power(x, 3)
y_6 = np.multiply(np.power(x, 2), np.log2(x))

plt.plot(x,y_1, label=r'$f_1(n) = 2^n$')
plt.plot(x,y_2, label=r'$f_2(n) = log(n)$' )
plt.plot(x,y_3, label=r'$f_3(n) = n$')
plt.plot(x,y_4, label=r'$f_4(n) = n!$')
plt.plot(x,y_5, label=r'$f_3(n) = n^3$')
plt.plot(x,y_6, label=r'$f_3(n) = n^2log(n)$')

axes = plt.gca()
# axes.set_ylim([1,30])
axes.set_ylim([0,3000])
axes.set_xlabel("Groesse fuer Eingabe n")
axes.set_ylabel("Laufzeit")
plt.legend()
plt.show()