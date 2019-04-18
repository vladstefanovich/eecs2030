package A1Q2;

/**
 * Represents an integer integral image, which allows the user to query the mean
 * value of an arbitrary rectangular subimage in O(1) time.  Uses O(n) memory,
 * where n is the number of pixels in the image.
 *
 * @author jameselder
 */
public class IntegralImage {

    private final int[][] integralImage;
    private final int imageHeight; // height of image (first index)
    private final int imageWidth; // width of image (second index)

    /**
     * Constructs an integral image from the given input image.  
     *
     * @author jameselder
     * @param image The image represented
     * @throws InvalidImageException Thrown if input array is not rectangular
     */
    public IntegralImage(int[][] image) throws InvalidImageException {
        //implement this method.
    	imageHeight = image.length;
    	for(int i = 0; i < imageHeight - 1; i++) {
    		if(image[i].length != image[i+1].length) {
    			throw new InvalidImageException();
    		}
    	}
    	imageWidth = image[0].length;
    	this.integralImage = new int[imageHeight][imageWidth];
    	for (int i = 0; i < image.length; i++) {
            System.arraycopy(image[i], 0, integralImage[i], 0, image[i].length);
        }
    	
    }

    /**
     * Returns the mean value of the rectangular sub-image specified by the
     * top, bottom, left and right parameters. The sub-image should include
     * pixels in rows top and bottom and columns left and right.  For example,
     * top = 1, bottom = 2, left = 1, right = 2 specifies a 2 x 2 sub-image starting
     * at (top, left) coordinate (1, 1).  
     *
     * @author jameselder
     * @param top top row of sub-image
     * @param bottom bottom row of sub-image
     * @param left left column of sub-image
     * @param right right column of sub-image
     * @return 
     * @throws BoundaryViolationException if image indices are out of range
     * @throws NullSubImageException if top > bottom or left > right
     */
    public double meanSubImage(int top, int bottom, int left, int right) throws BoundaryViolationException, NullSubImageException {
        //implement this method
    	if (top > bottom || left > right) {
    		throw new NullSubImageException();
    	}
    	int topleft = integralImage[top][left];
    	int bottomleft = integralImage[bottom][left];
    	int topright = integralImage[top][right];
    	int bottomright = integralImage[bottom][right];
    	
    	int height = bottomleft - topleft;
    	int width = topright - topleft;
    	
        return height*width; //dummy value - remove once coded.
    }
}