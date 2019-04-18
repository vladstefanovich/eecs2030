
public class RecursiveExampes {

	public int factorial(int n) {
		if (n == 0) {
			// base case
			return 1;
		} else {
			// recursive case
			return n * factorial(n - 1);
		}
	}

	public int bunnyEars(int bunnies) {
		if (bunnies == 0) {
			// base case
			return 0;
		} else {
			// recursive case
			return 2 + bunnyEars(bunnies - 1);
		}
	}

	public int fibonacci(int n) {
		if (n == 0) {
			// base case
			return 0;
		}
		if (n == 1) {
			// base case
			return 1;
		} else {
			// recursive case
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}

	public int bunnyEars2(int bunnies) {
		if (bunnies == 0) {
			// base case
			return 0;
		} else {
			// recursive case
			if (bunnies % 2 == 1) {
				return 2 + bunnyEars2(bunnies - 1);
			} else {
				return 3 + bunnyEars2(bunnies - 1);
			}
		}
	}

	public int triangle(int rows) {
		if (rows == 0) {
			// base case
			return 0;
		} else {
			// recursive case
			return rows + triangle(rows - 1);
		}
	}

	public int sumDigits(int n) {
		if (n / 10 == 0) {
			// base case
			return n;
		} else {
			// recursive case
			return n % 10 + sumDigits(n / 10);
		}
	}

	public int count7(int n) {
		if (n / 10 == 0) {
			// base case
			if (n != 7) {
				return 0;
			} else {
				return 1;
			}
		} else {
			// recursive case
			if (n % 10 == 7) {
				return 1 + count7(n / 10);
			} else {
				return 0 + count7(n / 10);
			}
		}
	}

	public int count8(int n) {
		if (n / 10 == 0) {
			// base case
			if (n != 8) {
				return 0;
			} else {
				return 1;
			}
		} else {
			// recursive case
			if (n % 100 == 88) {
				return 2 + count8(n / 10);
			} else if (n % 10 == 8) {
				return 1 + count8(n / 10);
			} else {
				return 0 + count8(n / 10);
			}
		}
	}
	
	public int powerN(int base, int n) {
		  if (n == 0) {
		    //base case
		    return 1;
		  } else {
		    //recursive case
		    return base * powerN(base, n-1);
		  }
		}

	public int countX(String str) {
		  if (str.length() == 0) {
		    //base case
		    return 0;
		  } else {
		    //recursive case
		    if (str.charAt(0) == 'x') {
		      return 1 + countX(str.substring(1, str.length()));
		    } else {
		      return 0 + countX(str.substring(1, str.length()));
		    }
		  }
		}
	
	public int countHi(String str) {
		  if (str.length() == 0) {
		    //base case
		    return 0;
		  } else if (str.length() == 1) {
		    //base case
		    return 0;
		  } else {
		    //recursive case
		    if (str.charAt(0) == 'h' && str.charAt(1) == 'i') {
		      return 1 + countHi(str.substring(2,str.length()));
		    } else {
		      return 0 + countHi(str.substring(1,str.length()));
		    }
		  }
		}

	public String changeXY(String str) {
	  if(str.length() == 0) {
		    //base case
		    return "";
		  }  else {
		    //recursive case
		    if (str.charAt(0) == 'x') {
		      return "y" + changeXY(str.substring(1, str.length()));
		    } else {
		      return str.charAt(0) + changeXY(str.substring(1, str.length()));
		    }
		  }
		}
	
	public String changePi(String str) {
		  if(str.length() == 0) {
		    //base case
		    return "";
		  } else if(str.length() == 1) {
		    //base case
		    return str.charAt(0) + changePi(str.substring(1, str.length()));
		  } else {
		    //Recursive case
		    if (str.charAt(0) == 'p' && str.charAt(1) == 'i') {
		      return "3.14" + changePi(str.substring(2, str.length()));
		    } else {
		      return str.charAt(0) + changePi(str.substring(1, str.length()));
		    }
		  }
		}

	public String noX(String str) {
		  if(str.length() == 0) {
		    //base case
		    return "";
		  } else {
		    //recursive case
		    if(str.charAt(0) == 'x') {
		      return "" + noX(str.substring(1, str.length()));
		    } else {
		      return str.charAt(0) + noX(str.substring(1, str.length()));
		    }
		  }
		}
	
	public boolean array6(int[] nums, int index) {
		  if(index == nums.length) {
		    //base case
		    return false;
		  } else {
		    //recursive case
		    if (nums[index] == 6) {
		      return true || array6(nums, index+1);
		    } else {
		      return false || array6(nums, index+1);
		    }
		  }
		}

	public int array11(int[] nums, int index) {
		  if (index == nums.length) {
		    //bc
		    return 0;
		  } else {
		    //rc
		    if(nums[index] == 11) {
		      return 1 + array11(nums, index+1);
		    } else {
		      return 0 + array11(nums, index+1);
		    }
		  }
		}

	public boolean array220(int[] nums, int index) {
		  if(index == nums.length || index == nums.length-1) {
		    //bc 
		    return false;
		  } else {
		    //rc
		    if (nums[index]*10 == nums[index+1]) {
		      return true || array220(nums, index+1);
		    } else {
		      return false || array220(nums, index+1);
		    }
		  }
		}

	public String allStar(String str) {
		  if (str.length() == 0) {
		    //base case
		    return "";
		  } else if (str.length() == 1) {
		    //base case
		    return str;
		  } else {
		    //recursive case
		    return str.charAt(0) + "*" + allStar(str.substring(1, str.length()));
		  }
		}

	public String pairStar(String str) {
		  if (str.length() == 0) {
		    //base case
		    return "";
		  } else if (str.length() == 1) {
		    //base case
		    return str;
		  } else {
		    if(str.charAt(0) == str.charAt(1)) {
		      return str.charAt(0) + "*" + pairStar(str.substring(1, str.length()));
		    } else {
		      return str.charAt(0) + pairStar(str.substring(1, str.length()));
		    }
		  }
		}
	
	public String endX(String str) {
		  if(str.length() == 0) {
		    //base case
		    return "";
		  } else {
		    if (str.charAt(0) == 'x') {
		        return endX(str.substring(1, str.length())) + "x";
		    } else {
		      return str.charAt(0) + endX(str.substring(1, str.length()));
		    }
		  }
		}

	public int countPairs(String str) {
		  if(str.length() < 3) {
		    //base case
		    return 0;
		  } else {
		    //recursive case
		    if (str.charAt(0) == str.charAt(2)) {
		      return 1 + countPairs(str.substring(1, str.length()));
		    } else {
		      return 0 + countPairs(str.substring(1, str.length()));
		    }
		  }
		}

	public int countAbc(String str) {
		  if(str.length() < 3) {
		    return 0;
		  } else {
		    if (str.substring(0,3).equals("abc") ||str.substring(0,3).equals("aba")) {
		      return 1 + countAbc(str.substring(1, str.length()));
		    } else {
		      return 0 + countAbc(str.substring(1, str.length()));
		    }
		  }
		}

	public int count11(String str) {
		  if(str.length() < 2) {
		    return 0;
		  } else {
		    if (str.substring(0,2).equals("11") ||str.substring(0,2).equals("1")) {
		      return 1 + count11(str.substring(2, str.length()));
		    } else {
		      return 0 + count11(str.substring(1, str.length()));
		    }
		  }
		}

	public String stringClean(String str) {
		  if(str.length() == 0) {
		    return "";
		  } else if (str.length() == 1) {
		    return str;
		  } else {
		    if(str.charAt(0) == str.charAt(1)) {
		      return stringClean(str.substring(1,str.length()));
		    } else {
		      return str.charAt(0) + stringClean(str.substring(1,str.length()));
		    }
		  }
		}

	public int countHi2(String str) {
		  if(str.length() < 2) {
		    return 0;
		  } else {
		    if(str.substring(0,2).equals("hi")) {
		      return 1 + countHi2(str.substring(2, str.length()));
		    } else if(str.substring(0,2).equals("xh")) {
		      return 0 + countHi2(str.substring(2, str.length()));
		    } else {
		      return 0 + countHi2(str.substring(1, str.length()));
		    }
		  }
		}

	public String parenBit(String str) {
		  if(str.length() == 0) {
		    return "";
		  } else if(str.equals("()")) {
		    return "()";
		  } else {
		    if(str.charAt(0) == '(') {
		        if(str.charAt(str.length()-1) == ')') {
		          return str;
		        } else {
		          return parenBit(str.substring(0, str.length()-1));
		        }
		    } else {
		      return parenBit(str.substring(1,str.length()));
		    }
		  }
		}
	
	public boolean nestParen(String str) {
		  if(str.length() == 0) {
		    return true;
		  } else if(str.length() == 1) {
		    return false;
		  } else {
		    if(str.charAt(0) == '(') {
		      if (str.charAt(str.length()-1) == ')') {
		        return true && nestParen(str.substring(1, str.length()-1));
		      } else {
		        return nestParen(str.substring(0, str.length()-1));
		      }
		    }  else {
		      return nestParen(str.substring(1, str.length()));
		    }
		    
		  }
		}

	public int strCount(String str, String sub) {
		  if(sub.length() > str.length()) {
		    return 0;
		  } else {
		    if(str.substring(0,sub.length()).equals(sub)) {
		      return 1 + strCount(str.substring(sub.length(), str.length()),sub);
		    } else {
		      return 0 + strCount(str.substring(1, str.length()),sub);
		    }
		  }
		}

	public boolean strCopies(String str, String sub, int n) {
		  if(n == 0){
		    return true;
		  } else if (str.length() < sub.length()) {
		    return false;
		  } else {
		    if (str.substring(0,sub.length()).equals(sub)){
		      return strCopies(str.substring(1,str.length()), sub, n-1);
		    } else {
		      return strCopies(str.substring(1,str.length()), sub, n);
		    }
		  }
		}
	
	public int strDist(String str, String sub) {
		  if(str.length() < sub.length()) {
		    return 0;
		  } else {
		    if(str.substring(0,sub.length()).equals(sub)) {
		      if(str.substring(str.length()-sub.length(),str.length()).equals(sub)) {
		        return str.length();
		      } else {
		        return strDist(str.substring(0,str.length()-1),sub);
		      }
		    } else {
		     return strDist(str.substring(1,str.length()),sub); 
		    }
		  }
		}
	
}
