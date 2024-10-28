from PIL import Image
import imagehash

def compare_images(image1_path, image2_path):
    # Open images
    image1 = Image.open(image1_path)
    image2 = Image.open(image2_path)

    # Calculate hash values
    hash1 = imagehash.average_hash(image1)
    hash2 = imagehash.average_hash(image2)

    # Compare hash values
    if hash1 == hash2:
        print("Images are identical.")
    else:
        print("Images are different.")

# Example usage
compare_images(r"C:\Users\swapnilsharma\Music\New folder\c.JPG", r"C:\Users\swapnilsharma\Music\New folder\b.JPG")
